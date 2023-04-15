package com.alonsogp.nhl_app.features.home.presentation

import android.graphics.drawable.PictureDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alonsogp.nhl_app.app.extensions.svg.GlideApp
import com.alonsogp.nhl_app.app.extensions.svg.SvgSoftwareLayerSetter
import com.alonsogp.nhl_app.databinding.FragmentTeamDetailBinding
import com.alonsogp.nhl_app.features.home.domain.TeamDetailWithRosterModel
import com.alonsogp.nhl_app.features.home.presentation.adapter.PlayersAdapter
import com.bumptech.glide.RequestBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamDetailFragment: Fragment() {

    private var binding: FragmentTeamDetailBinding? = null
    private val viewModel by viewModels<TeamDetailViewModel>()
    private val args: TeamDetailFragmentArgs by navArgs()
    private val playersAdapter = PlayersAdapter()
    private var requestBuilder: RequestBuilder<PictureDrawable>? = null
    private var imageViewNet: ImageView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamDetailBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getTeamDetail(args.teamId)
    }

    private fun setupView() {
        binding?.apply {
            layoutToolbar.sectionToolbar.apply {
                title = "Teams & Players"
                setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            listPlayers.apply {
                adapter = playersAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }
        }
    }

    private fun bind(teamDetail: TeamDetailWithRosterModel) {
        binding?.apply {

            imageViewNet = teamLogo

            requestBuilder = GlideApp.with(root.context)
                .`as`(PictureDrawable::class.java)
                .listener(SvgSoftwareLayerSetter())

            loadNet("https://www-league.nhlstatic.com/images/logos/teams-current-primary-light/${teamDetail.id}.svg")

            teamTitle.text = teamDetail.name
            teamName.text = teamDetail.name
            teamAbbreviation.text = teamDetail.abbreviation
            teamArena.text = teamDetail.venue.name
            teamCity.text = teamDetail.venue.city
            foundationYear.text = teamDetail.firstYearOfPlay
        }
    }

    private fun setupObservers() {
        val teamSubscriber =
            Observer<TeamDetailViewModel.UiState> { uiState ->
                uiState.error?.let { error ->
                    Log.d("@dev", "Error: $error")
                } ?: run {
                    uiState.teamDetail?.let { team ->
                        bind(team)
                        playersAdapter.setDataItems(team.roster)
                        binding?.listPlayers?.viewTreeObserver?.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                            override fun onGlobalLayout() {
                                val totalHeight = 163 * playersAdapter.itemCount
                                Log.d("@dev", "$totalHeight")
                                val layoutParams = binding?.listPlayers?.layoutParams
                                layoutParams?.height = totalHeight
                                binding?.listPlayers?.layoutParams = layoutParams
                                binding?.listPlayers?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                            }
                        })
                    }
                }
            }
        viewModel.uiState.observe(viewLifecycleOwner, teamSubscriber)
    }

    private fun loadNet(url: String) {
        val uri: Uri = Uri.parse(url)
        if (imageViewNet != null) {
            requestBuilder?.load(uri)?.into(imageViewNet!!)
        }
    }
}
