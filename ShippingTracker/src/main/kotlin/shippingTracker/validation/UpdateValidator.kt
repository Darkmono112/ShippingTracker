package shippingTracker.validation


class UpdateValidator(): Validator {

    private enum class PossibleUpdates(val paramNumber:Int){
        CREATED(4),
        LOCATION(4),
        SHIPPED(4),
        LOST(3),
        NOTE(4),
        DELIVERED(3),
        DELAYED(4),
        CANCEL(3)
    }
    private val creationValidator = CreationValidator()

    override fun validateInput(input:String):List<String>?{

        val possibleUpdates = PossibleUpdates.entries.map {  it.name }
        val updateList = input.split(",")
        //Check the list for possible types of updates and correct number of params
        if(!possibleUpdates.contains(updateList[0].uppercase())) return null

        if(updateList.size != PossibleUpdates.valueOf(updateList[0].uppercase()).paramNumber) return null


        //Check that numericals are entered in the 2nd and 3rd positon, include 4th for certain updates
        if(updateList[0].uppercase() in listOf("SHIPPED","DELAYED")){
            if(!checkNumberInput(updateList, 3)) return null
        }
        else{
            if(!checkNumberInput(updateList,2)) return null
        }

        if(updateList[0].uppercase() == "CREATED"){

            val creation = creationValidator.validateInput(input)
            return creation
        }

        return updateList
    }

    private fun checkNumberInput(input:List<String>, amount:Int):Boolean{
        for(i in amount downTo 2){
            try{
                input[i].toLong()
            }catch(e:Exception){
                return false
            }
        }
        return true
    }


}