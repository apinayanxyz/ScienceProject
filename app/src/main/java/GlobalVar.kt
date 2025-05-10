import com.google.android.material.color.utilities.Score
import kotlin.properties.Delegates

public class GlobalVar {
    companion object{
        public var score : Int = 0
        public var questionsAnswered :Int = 0
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