package shippingTracker.validation


class UpdateValidator(): Validator {

    private enum class PossibleUpdates(val paramNumber:Int){
        CREATED(3),
        LOCATION(4),
        SHIPPED(4),
        LOST(3),
        NOTE(4),
        DELIVERED(3),
        DELAYED(4),
        CANCEL(3)
    }

    override fun validateInput(input:String):List<String>?{

        val possibleUpdates = PossibleUpdates.entries.map {  it.name }
        val updateList = input.split(",")
        if(possibleUpdates.contains(updateList[0].uppercase())){
            if(updateList.size < PossibleUpdates.valueOf(updateList[0].uppercase()).paramNumber){
                return null
            }
            return updateList
        }
        return null
    }


}