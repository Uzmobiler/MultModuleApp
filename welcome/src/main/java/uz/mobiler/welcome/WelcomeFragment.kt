package uz.mobiler.welcome

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import uz.mobiler.core.SomeDependency
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeFragment : Fragment(R.layout.fragment_welcome) {

  @Inject lateinit var someDependency: SomeDependency
  @Inject lateinit var welcomeButtonClick: WelcomeButtonClick

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    requireActivity().title = "Module: welome"

    val textView = view.findViewById<TextView>(R.id.textView)
    textView.text = "${someDependency.getData(100)}"

    val button = view.findViewById<Button>(R.id.btn)
    button.setOnClickListener {
      welcomeButtonClick.goToNext()
    }
  }
}