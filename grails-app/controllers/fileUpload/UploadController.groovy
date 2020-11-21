package fileUpload

class UploadController {

    def uploadService

    def index() {
        redirect(action:"upload")
    }

    def upload() {
        def file = request.getFile('usercsv')
        if(file.empty) {
            render(view: 'upload', model: [result: 'Info : Please upload file'])
        } else {
            def result = uploadService.upload(file)
            render(view: 'upload', model: [result: result])
        }
    }
}
