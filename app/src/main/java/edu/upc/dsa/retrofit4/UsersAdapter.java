package edu.upc.dsa.retrofit4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserAdapterVH> {

    private List<UserResponse> userResponseList;
    private Context  context;
    private ClickedItem ClickedItem;



    public UsersAdapter(ClickedItem clickedItem) {
        this.ClickedItem = clickedItem;


    }
    public void setData (List<UserResponse> userResponseList){
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersAdapter.UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users,parent,false));  /*el inflater es para añadir las views*/
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UserAdapterVH holder, int position) {

        UserResponse userResponse = userResponseList.get(position);
        String username = userResponse.getUsername();
        String prefix;
        if (userResponse.isIs_active()) {
            prefix = "A";
        } else {
            prefix = "B";
        }

     holder.prefix.setText(prefix);
     holder.username.setText(username);
     holder.imagemore.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ClickedItem.ClickedUser(userResponse);
         }
     });


    }
    public interface ClickedItem {
        public void ClickedUser(UserResponse userResponse);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder{
        TextView username;
        TextView prefix;
        ImageView imagemore;



        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username); /*damos valores a lo que son los text view*/
            prefix = itemView.findViewById(R.id.prefix);
            imagemore = itemView.findViewById(R.id.imageMore);


        }
    }
}
