package com.rk.apiintegration.RoomDb

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.rk.apiintegration.databinding.SinglerowdataBinding
import com.rk.apiintegration.databinding.UpdateroomBinding

class AdapterRoom(val context: Context, val list: List<Entity>) :
    RecyclerView.Adapter<AdapterRoom.MyviewHolder>() {
    class MyviewHolder(val binding: SinglerowdataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val binding = SinglerowdataBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.binding.id.text = list[position].age.toString()
        holder.binding.title.text = list[position].firstName
        holder.binding.body.text = list[position].lastName
        holder.itemView.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            //set title for alert dialog
            builder.setTitle("confirmation")
            //set message for alert dialog
            builder.setMessage("Choose Action")
            builder.setPositiveButton("Delete") { dialogInterface, which ->
                val database = AppDatabase.getDatabase(context)
                val Da0 = database.userDao()
                Da0.delete(
                    Entity(
                        list[position].id,
                        list[position].firstName,
                        list[position].lastName,
                        list[position].age
                    )
                )
                holder.itemView.post {
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(context, InsertRoom::class.java)
                context.startActivity(intent)
            }

            //performing cancel action
            builder.setNeutralButton("Cancel") { dialogInterface, which ->
            }
            //performing negative action
            builder.setNegativeButton("Update") { dialogInterface, which ->
                val dialogBinding = UpdateroomBinding.inflate(LayoutInflater.from(context))
                val dialog = AlertDialog.Builder(context).setView(dialogBinding.root)
                    .setTitle("Update Note")
                    .setPositiveButton("Update")
                    { dialog, _ ->
                        val text1 = dialogBinding.editTextText.text.toString()
                        val text2 = dialogBinding.editTextText2.text.toString()
                        val text3 = dialogBinding.editTextNumberSigned.text.toString()

                        val database = AppDatabase.getDatabase(context)
                        val Da0 = database.userDao()

                        val age = text3.toIntOrNull() ?: 0
                        Da0.update(
                            Entity(
                                id=list[position].id,
                                firstName = text1, lastName = text2, age = age
                            )
                        )

                        val intent = Intent(context, InsertRoom::class.java)
                        context.startActivity(intent)

                        holder.itemView.post {
                            Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show()
                        }
                        dialog.dismiss()
                    }
                    .setNegativeButton("Cancel") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .create()
                dialogBinding.editTextText.setText(list[position].firstName)
                dialogBinding.editTextText2.setText(list[position].lastName)
                dialogBinding.editTextNumberSigned.setText(list[position].age.toString())
                dialog.show()

            }
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }
}
