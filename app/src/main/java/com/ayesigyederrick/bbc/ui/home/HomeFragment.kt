package com.ayesigyederrick.bbc.ui.home

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ayesigyederrick.bbc.R
import com.ayesigyederrick.bbc.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val myWebViewhome: WebView = view.findViewById(R.id.home_webview)
        //WebViewClient that override the shouldOverrideUrlLoading() method.
        myWebViewhome.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(
                view: WebView,
                url: String
            ): Boolean {
                view.loadUrl(url)
                return true
            }
        }

        myWebViewhome.loadUrl("https://www.bbc.com/")
        myWebViewhome.settings.javaScriptEnabled = true
        myWebViewhome.settings.allowContentAccess = true
        myWebViewhome.settings.domStorageEnabled = true
        myWebViewhome.settings.useWideViewPort = true


        myWebViewhome.canGoBack()
        myWebViewhome.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == MotionEvent.ACTION_UP && myWebViewhome.canGoBack()) {
                    myWebViewhome.goBack()
                    return true
                }
                return false
            }
        })


    }
}
