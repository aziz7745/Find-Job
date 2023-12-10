package com.example.job.Dev;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.job.Modele.Job;
import com.google.android.gms.tasks.OnSuccessListener;
import com.example.job.R;

import java.util.ArrayList;


public class ClassAdapt extends RecyclerView.Adapter<ClassAdapt.ViewHolder>  {
    private ArrayList<Job> ListJob;
    Context context;
    public ClassAdapt(ArrayList<Job> list, Context cnx)
    {
        ListJob=list;
        context=cnx;
    }




    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater inflayter = LayoutInflater.from(parent.getContext());
        View cc = inflayter.inflate(R.layout.modelepresentation, parent, false);
        return new ViewHolder(cc);
    }


    public void onBindViewHolder(@NonNull ClassAdapt.ViewHolder holder, int position)
    {
        Job job =ListJob.get(position);
        holder.ville.setText(job.getVille());
        holder.titre.setText(job.getTitre());
        holder.titreView.setText(job.getTitre());

        holder.jobis=job;
    }



    @Override
    public int getItemCount()
    {
        return (ListJob.size());
    }

    public class ViewHolder extends  RecyclerView.ViewHolder
    {

        private Job jobis;
        TextView titre,ville, titreView;
        ImageView model_image_user;
        private LinearLayout linear;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linear=itemView.findViewById(R.id.l);
            titre=itemView.findViewById(R.id.emp);
            ville=itemView.findViewById(R.id.vill);
            titreView = itemView.findViewById(R.id.titre_listView);
            model_image_user = itemView.findViewById(R.id.model_user_image);

            linear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String domain=jobis.getDomain();
                    String tit=jobis.getTitre();
                    String ville=jobis.getVille();
                    String mail=jobis.getMail();
                    String description=jobis.getDesc();
                    String userId = jobis.getUserId();
                    Intent intent = new Intent(context,PageDetaile.class);
                    intent.putExtra("dom",domain);
                    intent.putExtra("vil",ville);
                    intent.putExtra("tit",tit);
                    intent.putExtra("mail",mail);
                    intent.putExtra("description",description);
                    intent.putExtra("userId",userId );
                    context.startActivity(intent);


                }
            });


        }


    }

}
