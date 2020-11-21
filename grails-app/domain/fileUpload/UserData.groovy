package fileUpload

class UserData {

    static transactional = true

    String userId
    Integer amount
    String userName


    static constraints = {
        userId nullable: false, blank: false
        amount nullable: false, blank: false
        userName nullable: false, blank: false
    }
}
