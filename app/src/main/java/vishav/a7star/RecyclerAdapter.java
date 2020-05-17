package vishav.a7star;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ABC on 2/28/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] cue = {"Speak about a book favourite to you during your childhood",
            "Describe a person you admire the most",
            "Describe a cafe you visited",
            "An event in the history of our country",
            "Tell a situation when you used your imagination",
            "Describe a thing you would like to buy in the future",
            "Speak about an occasion/event that was important to you, for which you reached late.",
            "Describe a change you always wanted to be done in your local area",
            "Speak about useful thing that you once borrowed",
            "Talk about the leisure activity that you want to start",
            "Speak about an international celebrity, or personality who is controversial",
            "Describe your last visit to a zoo",
            "Describe your ideal job.",
            "Describe a family member who made you proud",
            "Describe a couple who you think have a happy marriage.",
            "Describe a place in other countries where you would like to work for a short time"
    };

    private String[] detail = {"1. Name of the book\n2. Who gave it to you\n3. What the book was about\n4. Why did you like the book.",
            "1. Name of the person\n2. Where you met him/her\n3. Why you admire him",
            "1. When did you visit\n2. With whom\n3. What did you like and dislike about it",
            "1. What was the event about\n2. When it occurred\n3. How you know about this event",
            "1. When you used it\n2. What you accomplished by using it\nWere you satisfied with the result",
            "1. What is it\n2. Why it will be useful for you\n3. When you will buy it",
            "1. What the occasion was\n2. When and where the occasion was\n3. What happened that day",
            "1. What it is\n2. Whose responsibility it is\n3. How it can be done",
            "1. What you borrowed\n2. Who lent this thing to you\n3. What kind of feature this thing has",
            "1. When you are starting it\n2. How useful this activity is to you\n3. What do you like about it",
            "1. The name of personality\n2. What he does for a living\n3. How that personality is controversial",
            "1. When you visited a zoo\n2. How that zoo was\n3. What you liked there",
            "1. The job designation\n2. The name of the company\n3. What job responsibilities you expect",
            "1. Who this person is\n2. When this happened\n3. What this person did",
            "1. Who they are\n2. How long they have been married\n3. How they live their lives",
            "• Where you would like to work\n• When would you like to go\n• Why you want to work there"
    };
    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public TextView itemCue;
        public TextView itemDetails;

        public ViewHolder(View view){
            super(view);
            itemCue = view.findViewById(R.id.info_text);
            itemDetails = view.findViewById(R.id.info_content);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuelist, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemCue.setText(cue[position]);
        holder.itemDetails.setText(detail[position]);
    }

    @Override
    public int getItemCount() {
        return cue.length;
    }
}