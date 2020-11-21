package fileUpload

import grails.gorm.transactions.Transactional


class UploadService {

    @Transactional
    def upload(def multiPartFile) {
        def line, error = false, message = 'Data uploaded successfully', lineNumber = 0
        InputStream fs = multiPartFile.inputStream
        File file = new File("D:/${multiPartFile.originalFilename}");
        multiPartFile.transferTo(file)

        // handing transaction to rollback changes as soon as error occurs.
        UserData.withTransaction { status ->
            file.withReader { reader ->
                while ((line = reader.readLine()) != null) {
                    if (!validateRowData(line)) {
                        error = true;
                        message = 'Error found at line number : ' + (lineNumber + 1)

                        // Rollback the changes in case of errors
                        status.setRollbackOnly()
                        break;
                    } else {
                        def row = line.split(',')
                        def b = new UserData(userId: row[0], amount: row[1], userName: row[2])
                        b.validate()
                        b.save(flush: true)
                    }
                    lineNumber++
                }
                return message
            }

        }
    }

    def validateRowData(def line) {
        def row  = line.split(',')
        if(row.size() != 3) {
            return false
        } else if (row[0].size() != 10){
            return false
        } else if(Integer.parseInt(row[1]) <=0) {
            return false
        }
        return true
    }
}
