package business

class ContactBusiness {
    fun save(name: String, phone: String){
        validate(name, phone)
    }

    fun remove(name: String, phone: String){
        validateRemove(name, phone)
    }
}