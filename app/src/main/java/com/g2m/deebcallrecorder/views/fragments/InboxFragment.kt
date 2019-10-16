package com.g2m.deebcallrecorder.views.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.g2m.deebcallrecorder.R
import com.g2m.deebcallrecorder.models.repositries.SaveAudioRepositry
import com.g2m.deebcallrecorder.viewModels.InboxCallViewModel
import com.g2m.deebcallrecorder.views.adapters.InboxAdapter
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_inbox.view.*
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class InboxFragment : DaggerFragment() {
    val adapter:InboxAdapter= InboxAdapter()

    @set:Inject
    lateinit var viewModel: InboxCallViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view:View=inflater.inflate(R.layout.fragment_inbox, container, false)

        // Inflate the layout for this fragment
        view.res_inbox_caller.layoutManager=LinearLayoutManager(activity)
        view.res_inbox_caller.adapter=adapter

        //val viewModel = ViewModelProviders.of(this).get(InboxCallViewModel::class.java)
        viewModel.getAllinboxCalls().observe(this, Observer {
            adapter.addall (it)
        })
        return view
    }

}
