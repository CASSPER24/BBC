package com.ayesigyederrick.bbc.ui.Search

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ayesigyederrick.bbc.R
import com.ayesigyederrick.bbc.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        val myWebViewnotifications: WebView = view.findViewById(R.id.myaccountweb)
        //WebViewClient that override the shouldOverrideUrlLoading() method.
        myWebViewnotifications.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }

        myWebViewnotifications.loadUrl("https://account.bbc.com/signin?realm=%2F&clientId=Account&context=homepage&ptrt=https%3A%2F%2Fwww.bbc.com%2F&userOrigin=HOMEPAGE_GNL&isCasso=false&action=sign-in&redirectUri=https%3A%2F%2Fsession.bbc.com%2Fsession%2Fcallback%3Frealm%3D%2F&service=IdSignInService&nonce=APYkZw6F-aUT87fGSMAhmTxFFLaR7TSSzkHk")
        myWebViewnotifications.settings.javaScriptEnabled = true
        myWebViewnotifications.settings.allowContentAccess = true
        myWebViewnotifications.settings.domStorageEnabled = true
        myWebViewnotifications.settings.useWideViewPort = true

        myWebViewnotifications.canGoBack()
        myWebViewnotifications.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP && myWebViewnotifications.canGoBack()) {
                    myWebViewnotifications.goBack()
                    return true
                }
                return false
            }
        })

    }
}
