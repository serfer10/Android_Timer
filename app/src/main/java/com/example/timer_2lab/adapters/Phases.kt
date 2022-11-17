package com.example.timer_2lab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.tabatatimer.R
import com.example.tabatatimer.services.TimerPhase

class PhasesAdapter() : RecyclerView.Adapter<PhasesAdapter.MyViewHolder>() {
    private var phaseList = emptyList<TimerPhase>()
    private var selectPhase = 0

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.phase_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = phaseList[position]
        if (selectPhase == position) {
            holder.itemView.findViewById<CardView>(R.id.phase_list_item).setCardBackgroundColor(("#FF03DAC5".toColorInt()))
        } else holder.itemView.findViewById<CardView>(R.id.phase_list_item).setCardBackgroundColor(("#FFFFFFFF".toColorInt()))
        when (currentItem) {
            TimerPhase.PREPARATION -> holder.itemView.findViewById<TextView>(R.id.title_of_phase).text =
                holder.itemView.context.getString(R.string.warm_up_label)
            TimerPhase.WORKOUT -> holder.itemView.findViewById<TextView>(R.id.title_of_phase).text =
                holder.itemView.context.getString(R.string.workout_label)
            TimerPhase.REST -> holder.itemView.findViewById<TextView>(R.id.title_of_phase).text =
                holder.itemView.context.getString(R.string.rest_label)
            else -> {}
        }


    }

    override fun getItemCount(): Int {
        return phaseList.size
    }

    fun setData(phaseList: List<TimerPhase>) {
        this.phaseList = phaseList
        notifyDataSetChanged()
    }

    fun setSelectPhase(position: Int) {
        this.selectPhase = position
        notifyDataSetChanged()
    }

    fun dropPhase(position: Int) {
        var newList = this.phaseList.toMutableList()
        newList.removeAt(position)
        this.phaseList = newList
        notifyDataSetChanged()


    }
}