package business

import entity.ContactEntity
import repository.ContactRepository

class ContactBusiness {

    private var validation = business.Validations()

    fun saveNewContact(name: String, phone: String){

        validation.validateNewContact(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.saveNewContact(contact)
    }

    fun removeContact(name: String, phone: String){

        validation.validateRemove(name, phone)

        val contact = ContactEntity(name, phone)
        ContactRepository.removeContact(contact)

    }

    fun getListContact(): List<ContactEntity> {
        return ContactRepository.getListContact()
    }

    fun getContactCountDescription() : String {

        val list = getListContact()
        if (list.isEmpty()){
            return "0 Contatos"
        }
        if (list.size == 1){
            return "1 Contato"
        }
        return "${list.size} Contatos"
    }
}