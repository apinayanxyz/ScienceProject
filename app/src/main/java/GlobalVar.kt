import kotlin.properties.Delegates

public class GlobalVar {
    public var score:Int?=0
    public var questionsAnswered:Int?=0
    companion object{
        public var score by Delegates.notNull<Int>()
        public var questionsAnswered by Delegates.notNull<Int>()
    }
    init {
        if (score==null){
            score=0
        }
        if (questionsAnswered==null){
            questionsAnswered=0
        }
    }
}