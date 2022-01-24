package scopus.raoufi.ershad.scopus;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import scopus.raoufi.ershad.scopus.Model.Entry;

import static scopus.raoufi.ershad.scopus.R.id.txtPage;

/**
 * Created by Ershad on 04/05/2017.
 */

public class HotArticle_Adapter extends RecyclerView.Adapter<HotArticle_Adapter.ViewHolder> {

    ArrayList<Entry> _article;
    String _country;
    Context ctx;
    public HotArticle_Adapter(ArrayList<Entry> list) {
        _article = list;
    }
    public HotArticle_Adapter(ArrayList<Entry> list,String str,Context c) {
        _article = list;
        _country = str;
        ctx = c;
    }
    @Override
    public HotArticle_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_item,parent,false));
    }
    //Bind Data To Field
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        Animation animation = AnimationUtils.loadAnimation(ctx, R.anim.right);
        holder.itemView.setAnimation(animation);

        if(_country.equals("Iran"))
        {
            holder.img.setImageResource(R.drawable.iran);
        }else if (_country.equals("Germany"))
        {
            holder.img.setImageResource(R.drawable.germany);
        }else if (_country.equals("Spain"))
        {
            holder.img.setImageResource(R.drawable.spain);
        }else if (_country.equals("Sweden"))
        {
            holder.img.setImageResource(R.drawable.sweden);
        }else if (_country.equals("United%20Kingdom"))
        {
            holder.img.setImageResource(R.drawable.united_kingdom);
        }
        holder.txtTitle.setText(_article.get(position).getDcTitle());
        holder.txtCreator.setText(_article.get(position).getDcCreator());
        holder.txtDate.setText(_article.get(position).getPrismCoverDate());

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder d  = new AlertDialog.Builder(holder.itemView.getContext());
                final LayoutInflater inflater = (LayoutInflater) holder.itemView.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view =  inflater.inflate(R.layout.modal_details,null);

                TextView txtCreator = (TextView) view.findViewById(R.id.txtName);
                TextView txtUni = (TextView) view.findViewById(R.id.txtUni);
                TextView txtCity = (TextView) view.findViewById(R.id.txtCity);
                TextView txtCountry = (TextView) view.findViewById(R.id.txtCountry);
                TextView txtId = (TextView) view.findViewById(R.id.txtId);
                TextView txtPage = (TextView)view.findViewById(R.id.txtPage);
                TextView txtCitation = (TextView) view.findViewById(R.id.txtCitation);
                ImageView icon = (ImageView)view.findViewById(R.id.icon);


                if(_country.equals("Iran"))
                {
                    icon.setImageResource(R.drawable.iran);
                }else if (_country.equals("Germany"))
                {
                    icon.setImageResource(R.drawable.germany);
                }else if (_country.equals("Spain"))
                {
                    icon.setImageResource(R.drawable.spain);
                }else if (_country.equals("Sweden"))
                {
                    icon.setImageResource(R.drawable.sweden);
                }else if (_country.equals("United%20Kingdom"))
                {
                    icon.setImageResource(R.drawable.united_kingdom);
                }

                txtCreator.setText(_article.get(position).getDcCreator());
                txtUni.setText(_article.get(position).getAffiliation().get(0).getAffilname());
                txtCity.setText(_article.get(position).getCitedbyCount());
                txtCity.setText(_article.get(position).getAffiliation().get(0).getAffiliationCity());
                txtCountry.setText(_article.get(position).getAffiliation().get(0).getAffiliationCountry());
                txtId.setText(_article.get(position).getSourceId());
                txtCitation.setText(_article.get(position).getCitedbyCount());
                txtPage.setText(_article.get(position).getPrismPageRange());

                d.setView(view);
                final AlertDialog dialog =  d.create();
                dialog.getWindow().getAttributes().windowAnimations=R.style.ProgressDialog;
                dialog.show();

                ImageView close = (ImageView) view.findViewById(R.id.Close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return _article.size();
    }


    //Declare Recycler Field...
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtCreator,txtDate;
        ImageView img;
        Button btnDetails;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtTitle  = (TextView) itemView.findViewById(R.id.txtTitle);
            txtDate  = (TextView) itemView.findViewById(R.id.txtDate);
            txtCreator  = (TextView) itemView.findViewById(R.id.txtCreator);
            btnDetails = (Button) itemView.findViewById(R.id.btnRef);
            img  = (ImageView) itemView.findViewById(R.id.imgBank);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
