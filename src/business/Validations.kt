package business

class Validations {
     fun validateNewContact(name: String, phone: String) {
        if (name == "") {
            throw Exception("Nome é obrigatório")
        }
        if (phone == "") {
            throw Exception("Telefone é obrigatório")
        }
    }

    fun validateRemove(name: String, phone: String) {
        if (name == "" || phone == "") {
            throw Exception("É necessário selecionar um contato antes de remover")
        }
    }
}