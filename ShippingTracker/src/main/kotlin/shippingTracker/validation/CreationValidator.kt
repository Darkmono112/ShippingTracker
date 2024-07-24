package shippingTracker.validation

class CreationValidator():Validator {

    override fun validateInput(input: String): List<String>? {

        val updateList = input.split(",")
        val valid = listOf("overnight","bulk","standard","express")
        if(valid.contains(updateList[3])){

            return updateList
        }

        return null

    }
}