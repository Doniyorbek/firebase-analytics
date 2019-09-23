package mashrabboy.technologies.fanalytics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.crashlytics.android.Crashlytics
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            Crashlytics.getInstance().crash()
        }

        btnSend.setOnClickListener {
            val bundle = Bundle()
            val firebaseAnalytics = FirebaseAnalytics.getInstance(this)
            firebaseAnalytics.setAnalyticsCollectionEnabled(true)
            bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "256")
            bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Custom Statistic Name")
            bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
        }

    }
}
