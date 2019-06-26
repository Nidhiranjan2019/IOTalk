package in.codepredators.delta.Classes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import in.codepredators.delta.Activities.Chat;
import in.codepredators.delta.R;


public class RecyclerAdapterChatRecycler extends RecyclerView.Adapter<RecyclerAdapterChatRecycler.ViewHolderText> {

    private List<Message> messageTextList;
    private Context mContext;
    private ImageView image;
    private ItemClickListener itemClickListener;
    // private int imagesCount = 0;

    public class ViewHolderText extends RecyclerView.ViewHolder {

        public ConstraintLayout backgroundColor;
        public LinearLayout adjustingMessageGravity;
        public TextView dayText;
        public LinearLayout messageBackground;
        public View senderView;
        public TextView senderName;
        public RelativeLayout replyMessage;//shortform rM
        public View rMSenderView;
        public TextView rMSenderName;
        public TextView rMType;
        public ImageView rMPic;
//        public ImageView rMCancel;
        public LinearLayout contactMessage; //cM
        public ImageView cMPic;
        public TextView cMText;
        public ImageView messageImage;
        public TextView messageTextContent;
        public TextView messageType;
        public ImageView starredMessageStatusPic;
        public TextView messageTime;
        public ImageView messageStatus;
        public View cMView;
        public TextView addContact;

        //public View selectMessageView;
        public ViewHolderText(@NonNull View itemView) {
            super(itemView);


            adjustingMessageGravity = itemView.findViewById(R.id.messageContainer);
            dayText = itemView.findViewById(R.id.messageDay);
            messageBackground = itemView.findViewById(R.id.messageLinearLayoutContainer);
            senderView = itemView.findViewById(R.id.senderView);
            senderName = itemView.findViewById(R.id.senderName);
            replyMessage = itemView.findViewById(R.id.replyMessage);
            rMSenderView = itemView.findViewById(R.id.replyMessageSenderView);
            rMSenderName = itemView.findViewById(R.id.replyMessageSenderName);
            rMType = itemView.findViewById(R.id.replyMessageType);
            rMPic = itemView.findViewById(R.id.replyMessagePic);
//            rMCancel = itemView.findViewById(R.id.replyMessageCancel);
            contactMessage = itemView.findViewById(R.id.contactMessage);
            cMPic = itemView.findViewById(R.id.contactMessagePic);
            cMText = itemView.findViewById(R.id.contactMessageText);
            messageImage = itemView.findViewById(R.id.imageMessage);
            messageTextContent = itemView.findViewById(R.id.messageTextContent);
            messageType = itemView.findViewById(R.id.fileTypeTextView);
            starredMessageStatusPic = itemView.findViewById(R.id.starredMessageStatusPic);
            messageTime = itemView.findViewById(R.id.messageTimeTextView);
            messageStatus = itemView.findViewById(R.id.messageStatusImageView);
            cMView = itemView.findViewById(R.id.contactMessageView);
            addContact = itemView.findViewById(R.id.addContactMessage);
            backgroundColor = itemView.findViewById(R.id.backgroundColor);
//selectMessageView = itemView.findViewById(R.id.selectedMessageView);
        }
    }

    public RecyclerAdapterChatRecycler(List<Message> messageTextList, Context mContext) {
        this.messageTextList = messageTextList;
        this.mContext = mContext;
    }


//    public void updateMessageListItems(List<Message> employees) {
//        Log.i("numberofitemsinListE", String.valueOf(employees.size()));
//        final MessageDiffCallBack diffCallback = new MessageDiffCallBack(this.messageTextList, employees);
//        final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
//        Log.i("numberofitemsinList", String.valueOf(this.messageTextList.size()));
//        Log.i("numberofitemsinListE", String.valueOf(employees.size()));
//        this.messageTextList.clear();
//        Log.i("numberofitemsinListE", String.valueOf(employees.size()));
//        this.messageTextList.addAll(employees);
//
//        Log.i("numberofitemsinListE", String.valueOf(employees.size()));
//        Log.i("numberofItem", String.valueOf(getItemCount()));
//        diffResult.dispatchUpdatesTo(this);
//    }


    @NonNull
    @Override
    public ViewHolderText onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.messagerecyleritem, viewGroup, false);
        return new ViewHolderText(view);
    }

    int a = 0;

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderText viewHolder, final int i) {
        final Message messageInfo = messageTextList.get(i);

//                    ColorDrawable viewColor = (ColorDrawable) viewHolder.adjustingMessageGravity.getBackground();
//                    int colorId = viewColor.getColor();
//                    if(colorId == Color.parseColor("#1af0ff"))
//                    {
//                        Log.i("longclicked", String.valueOf(i));
//                        viewHolder.adjustingMessageGravity.setBackgroundColor(Color.parseColor("#00000000"));
//                     }

        viewHolder.contactMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Log.i("insideContactOnClick", String.valueOf(i));
//           Chat c = new Chat();
//           c.showPdf(messageTextList.get(i).getMessageFileLocalAdress());

            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                viewHolder.backgroundColor.setBackgroundColor(Color.parseColor("#1af0ff"));
                //Toast.makeText(getContext(), "long Click" + position+"  ", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorDrawable viewColor = (ColorDrawable) viewHolder.backgroundColor.getBackground();
                int colorId = viewColor.getColor();
                if (colorId == Color.parseColor("#1af0ff")) {
                    viewHolder.backgroundColor.setBackgroundColor(Color.parseColor("#00000000"));
                } else {
                    viewHolder.backgroundColor.setBackgroundColor(Color.parseColor("#1af0ff"));
                }
            }
        });

        if (messageInfo.getMessageType().charAt(0) == 'N') {
            viewHolder.messageBackground.setVisibility(View.GONE);
            viewHolder.messageTextContent.setVisibility(View.GONE);
            viewHolder.messageImage.setVisibility(View.GONE);
            viewHolder.contactMessage.setVisibility(View.GONE);
            viewHolder.dayText.setVisibility(View.VISIBLE);
        } else {
            viewHolder.dayText.setVisibility(View.GONE);
            viewHolder.messageBackground.setVisibility(View.VISIBLE);
            if (messageInfo.getMessageType().charAt(0) == '1')
            {
                viewHolder.messageTextContent.setVisibility(View.VISIBLE);
                viewHolder.messageTextContent.setText(messageInfo.getMessageText());

                if (messageInfo.getMessageType().charAt(1) == '0') {
                    {
                        viewHolder.messageImage.setVisibility(View.GONE);
                    }
                }
                else
                if (messageInfo.getMessageType().charAt(3) == '0') {
                    viewHolder.contactMessage.setVisibility(View.GONE);
                }
                //charAt(2)
                // is remaining
            }
            else
            {
                viewHolder.messageTextContent.setVisibility(View.GONE);
            }

            if (messageInfo.getMessageType().charAt(1) == '1') {

                viewHolder.messageImage.setVisibility(View.VISIBLE);
//                if (messageInfo.getMessageImageBitmap() == null) //instead of this u have to check in phone storage
//                {
                StorageReference mStorageRef;
                mStorageRef = FirebaseStorage.getInstance().getReference();
                StorageReference storageReference = mStorageRef.child(messageInfo.getMessageImage());

                if (messageInfo.getMessageImageBitmap() == null && messageInfo.getMessageType().charAt(1) == '1')
                {
                    String root = Environment.getExternalStorageDirectory().toString() + "/IOTalk" + "/Images";
                    File myDir = new File(root);
                    myDir.mkdirs();
                    File file = new File(myDir,messageInfo.getMessageImage());
                    if (file.exists())
                    {
                        Log.i("GlideAppWorking","Nope File Exist");
//                                                Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        viewHolder.messageImage.setImageBitmap(messageInfo.getMessageImageBitmap());
                        Log.i("GlideAppWorking","Nope File Exist2");
                    }
                    else
                    {
                        Log.i("GlideAppWorking", "Start");
                        GlideApp.with(mContext)
                                .asBitmap()
                                .load(storageReference)
                                .into(new SimpleTarget<Bitmap>() {
                                    @Override
                                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                        viewHolder.messageImage.setImageBitmap(resource);
                                        messageInfo.setMessageImageBitmap(resource);
                                        saveImage(resource, messageInfo.getMessageImage());
                                    }
                                });
                        //.into(viewHolder.messageImage);
                        Log.i("GlideAppWorking", "End");
                    }

                } else {
//                assert  messageInfo.getMessageImageBitmap()!=null : "Null";
//                 Bitmap bitmap = Bitmap.createScaledBitmap(messageInfo.getMessageImageBitmap(),600,600,true);
//                //viewHolder.messageStatus.setImageBitmap(messageInfo.getMessageImageBitmap());
                    viewHolder.messageImage.setImageBitmap(messageInfo.getMessageImageBitmap());
                }
            }
            else
            {

                viewHolder.messageImage.setVisibility(View.GONE);
            }
            if (messageInfo.getMessageType().charAt(0) == '0')
                viewHolder.messageTextContent.setVisibility(View.GONE);

            else {
                viewHolder.messageImage.setVisibility(View.GONE);
            }
            if (messageInfo.getMessageType().charAt(3) == '1')
            {
                Log.i("FileDownloading","insideBefore[null]condition");
                //check that messageinfo has file address if null than download if contain than get from storage
                if(messageInfo.getMessageFileLocalAdress() == null)
                {
                    Log.i("FileDownloading","inside[null]condition");
                    File myDir = new File(mContext.getExternalFilesDir(null) + "/IOTalk" + "/PDF" );
                    myDir.mkdirs();
                    File localfile = new File(myDir,messageInfo.getMessageFile());
                    StorageReference mStorageRef = FirebaseStorage.getInstance().getReference();
                    StorageReference storageReference = mStorageRef.child(messageInfo.getMessageFile());
                    storageReference.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(mContext,"File downloaded",Toast.LENGTH_SHORT).show();
                            Log.i("task","complete");
                            messageInfo.setMessageFileLocalAdress(mContext.getExternalFilesDir(null) + "/IOTalk" + "/PDF" + "/" + messageInfo.getMessageFile());
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
                }
                else
                {
                    Log.i("FileDownloading","outside[null]condition");
                }
                viewHolder.contactMessage.setVisibility(View.VISIBLE);
                viewHolder.cMPic.setImageResource(R.drawable.tickicon);
                viewHolder.cMText.setText("Raj Kothari");
                if (messageInfo.getMessageType().charAt(0) == '0')
                {
                    viewHolder.messageTextContent.setVisibility(View.GONE);
                }
            }
            else
            {
                viewHolder.contactMessage.setVisibility(View.GONE);
            }
            viewHolder.senderName.setText(FirebaseDatabase.getInstance().getReference().child("users").child(messageInfo.getMessagesenderUID()).child("userName").getKey());

            viewHolder.messageTime.setText(messageInfo.getMessageTime());
        }

    }

    private void saveImage(Bitmap finalBitmap, String image_name)
    {
        Log.i("savingimage","started");
        String root =  mContext.getExternalFilesDir(null) + "/IOTalk" + "/Images";
        File myDir = new File(root);
        myDir.mkdirs();
        String fname =image_name;
        File file = new File(myDir, fname);
        if (file.exists())
            file.delete();
        Log.i("LOAD", root + fname);
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            Log.i("savingimage","undercatch");
            e.printStackTrace();
        }
        Log.i("savingimage","done");

    }
    @Override
    public int getItemCount() {

        return messageTextList.size();
    }

}

