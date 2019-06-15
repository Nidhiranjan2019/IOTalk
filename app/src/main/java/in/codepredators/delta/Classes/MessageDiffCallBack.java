package in.codepredators.delta.Classes;


import android.util.Log;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class MessageDiffCallBack extends DiffUtil.Callback {

    private final List<Message> mOldMessageList;
    private final List<Message> mNewMessageList;

    public MessageDiffCallBack(List<Message> oldEmployeeList, List<Message> newEmployeeList) {
        this.mOldMessageList = oldEmployeeList;
        this.mNewMessageList = newEmployeeList;
    }

    @Override
    public int getOldListSize() {
        return mOldMessageList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewMessageList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldMessageList.get(oldItemPosition).getMID() == mNewMessageList.get(
                newItemPosition).getMID();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        final Message oldEmployee = mOldMessageList.get(oldItemPosition);
        final Message newEmployee = mNewMessageList.get(newItemPosition);
        Log.i("areContentcalled","Yes");
        return oldEmployee.getMessageText().equals(newEmployee.getMessageText());
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        // Implement method if you're going to use ItemAnimator
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
