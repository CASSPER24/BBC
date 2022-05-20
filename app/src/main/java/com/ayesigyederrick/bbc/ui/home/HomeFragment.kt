package com.ayesigyederrick.bbc.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
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
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
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

    }
}
