package com.mbm.ftn.mbm.adapters;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.mbm.ftn.mbm.R;
import com.mbm.ftn.mbm.activities.ImportantNumbersActivity;
import com.mbm.ftn.mbm.activities.NumbersActivity;
import com.mbm.ftn.mbm.dialogs.NumberPickedDialog;
import com.mbm.ftn.mbm.models.Number;
import com.mbm.ftn.mbm.models.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makso on 6/17/2017.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private static ViewHolder.ClickListener clickListener;
    private List<Profile> profileList;

    public ProfileAdapter(List<Profile> profileList) {
        this.profileList = profileList;
    }

    /////////////////////////////////////Beginning of inner class///////////////////////////////////////////
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private TextView firstName;
        private TextView lastName;
        private TextView phone;
        private TextView email;
        private TextView message;

        public ViewHolder(View view, ClickListener listener) {
            super(view);
            clickListener = listener;
            title = (TextView) view.findViewById(R.id.title);
            firstName = (TextView) view.findViewById(R.id.firstName);
            lastName = (TextView) view.findViewById(R.id.lastName);
            phone = (TextView) view.findViewById(R.id.phone);
            email = (TextView) view.findViewById(R.id.email);
            message = (TextView) view.findViewById(R.id.message);
            view.setOnClickListener(this);
            //number.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v instanceof TextView) {
                //clickListener.onTextItemClick(getAdapterPosition(), (TextView) v);
            } else {
                clickListener.onItemClick(getAdapterPosition(), v);
            }
        }

        public interface ClickListener {
            void onItemClick(int position, View v);

            //void onTextItemClick(int position, TextView v);
        }
    }
    /////////////////////////////////////End of inner class///////////////////////////////////////////

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_profile, parent, false);

        final ProfileAdapter.ViewHolder viewHolder = new ViewHolder(view, new ProfileAdapter.ViewHolder.ClickListener() {

            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(v.getContext(), "SHORT is selected!", Toast.LENGTH_SHORT).show();

                TextView title = (TextView) v.findViewById(R.id.title);
                TextView firstName = (TextView) v.findViewById(R.id.firstName);
                TextView lastName = (TextView) v.findViewById(R.id.lastName);
                TextView phone = (TextView) v.findViewById(R.id.phone);
                TextView email = (TextView) v.findViewById(R.id.email);
                TextView message = (TextView) v.findViewById(R.id.message);

                //Pozivanje Dialoga i prosledjivanje parametara
              /*  Bundle bundle = new Bundle();
                bundle.putString("titleName", title.getText().toString());
                bundle.putString("number", number.getText().toString());
                bundle.putString("website", website.getText().toString());
                bundle.putString("address", address.getText().toString());
                NumberPickedDialog numberPickedDialog = new NumberPickedDialog();
                numberPickedDialog.setArguments(bundle);
                numberPickedDialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

                //Log.d("KONTEKST", "JE" + parent.getContext());
                //Log.d("KONTEKST", "JEqweqe "+ (NumbersActivity)parent.getContext());
                if (parent.getContext() instanceof NumbersActivity) {
                    android.support.v4.app.FragmentManager fragmentManager = ((NumbersActivity) parent.getContext()).getSupportFragmentManager();
                    numberPickedDialog.show(fragmentManager, "showNumberPickedDialogTAG");
                } else {
                    android.support.v4.app.FragmentManager fragmentManager = ((ImportantNumbersActivity) parent.getContext()).getSupportFragmentManager();
                    numberPickedDialog.show(fragmentManager, "showNumberPickedDialogTAG");
                }*/

            }

            /*@Override
            public void onTextItemClick(int position, TextView v) {
                Toast.makeText(v.getContext(),  "Text is selected!", Toast.LENGTH_SHORT).show();
            }*/
        });

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        holder.title.setText(profile.getTitle());
        holder.firstName.setText(profile.getFirstName());
        holder.lastName.setText(profile.getLastName());
        holder.phone.setText(profile.getPhone());
        holder.email.setText(profile.getEmail());
        holder.message.setText(profile.getMessage());

       /* if (number.getDescription() == null || number.getDescription().toString().isEmpty()) {
            holder.description.setVisibility(View.GONE);
        } else {
            holder.description.setVisibility(View.VISIBLE);
        }*/
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }


    public void setOnItemClickListener(ViewHolder.ClickListener clickListener) {
        ProfileAdapter.clickListener = clickListener;
    }


}
