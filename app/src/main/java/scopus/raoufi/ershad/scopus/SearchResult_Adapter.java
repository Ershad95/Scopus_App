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

/**
 * Created by Ershad on 06/05/2017.
 */

public class SearchResult_Adapter extends RecyclerView.Adapter<SearchResult_Adapter.ViewHolder>{
    ArrayList<Entry> _article;
    Context _ctx;
    public SearchResult_Adapter(ArrayList<Entry> list,Context c) {
        _article = list;
        _ctx = c;

    }
    @Override
    public SearchResult_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SearchResult_Adapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,parent,false));
    }
    @Override
    public void onBindViewHolder(final scopus.raoufi.ershad.scopus.SearchResult_Adapter.ViewHolder holder, final int position) {

        Animation animation = AnimationUtils.loadAnimation(_ctx, R.anim.right);
        holder.itemView.setAnimation(animation);

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
                TextView txtCity = (TextView) view.findViewById(R.id.txtCity);
                TextView txtCountry = (TextView) view.findViewById(R.id.txtCountry);
                TextView txtId = (TextView) view.findViewById(R.id.txtId);
                TextView txtCitation = (TextView) view.findViewById(R.id.txtCitation);
                TextView txtUni = (TextView) view.findViewById(R.id.txtUni);
                TextView txtPage = (TextView)view.findViewById(R.id.txtPage);

                txtCreator.setText(_article.get(position).getDcCreator());
                txtCity.setText(_article.get(position).getCitedbyCount());
                txtCity.setText(_article.get(position).getAffiliation().get(0).getAffiliationCity());
                txtCountry.setText(_article.get(position).getAffiliation().get(0).getAffiliationCountry());
                txtUni.setText(_article.get(position).getAffiliation().get(0).getAffilname());
                txtId.setText(_article.get(position).getSourceId());
                txtCitation.setText(_article.get(position).getCitedbyCount());
                txtPage.setText(_article.get(position).getPrismPageRange());


                d.setView(view);
                final AlertDialog dialog =  d.create();
                dialog.getWindow().getAttributes().windowAnimations=R.style.ProgressDialog;
                dialog.show();

                ImageView close = (ImageView) view.findViewById(R.id.Close);
                ImageView ref = (ImageView) view.findViewById(R.id.imgRef);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.hide();
                        dialog.dismiss();
                    }
                });
                ref.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = _article.get(position).getLink().get(2).getHref();
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        _ctx.startActivity(browserIntent);
//                        dialog.hide();
//                        dialog.dismiss5();

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}

