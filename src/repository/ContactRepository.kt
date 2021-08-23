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

        }

        fun getListContact(): List<ContactEntity> {
            return contactList
        }
    }

}