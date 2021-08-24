package repository

import business.Validations
import entity.ContactEntity

class ContactRepository {

    companion object {

        private val contactList = mutableListOf<ContactEntity>()

        fun saveNewContact(contact: ContactEntity) {
            contactList.add(contact)
        }

        fun removeContact(contact: ContactEntity) {


            for (c in contactList.withIndex()){
                if (c.value.name == contact.name && c.value.phone == contact.phone){
                    contactList.removeAt(c.index)
                    break
                }
 
            }


        }

        fun getListContact(): List<ContactEntity> {
            return contactList
        }
    }

}