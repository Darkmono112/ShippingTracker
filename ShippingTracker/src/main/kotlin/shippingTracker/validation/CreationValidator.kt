package shippingTracker.validation

class CreationValidator():Validator {



    override fun validateInput(input: String): List<String>? {

        val updateList = input.split(",")
        if(updateList[3] in listOf("overnight","bulk","standard","express")) return updateList
        return null

    }
}