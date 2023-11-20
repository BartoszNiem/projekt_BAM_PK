// Generated by view binder compiler. Do not edit!
package com.example.projekt_bam.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projekt_bam.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditProfileBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonSaveChanges;

  @NonNull
  public final EditText editTextAddress;

  @NonNull
  public final EditText editTextEmail;

  @NonNull
  public final EditText editTextFirstName;

  @NonNull
  public final EditText editTextIdNumber;

  @NonNull
  public final EditText editTextLastName;

  @NonNull
  public final EditText editTextPesel;

  @NonNull
  public final EditText editTextPhoneNumber;

  private ActivityEditProfileBinding(@NonNull RelativeLayout rootView,
      @NonNull Button buttonSaveChanges, @NonNull EditText editTextAddress,
      @NonNull EditText editTextEmail, @NonNull EditText editTextFirstName,
      @NonNull EditText editTextIdNumber, @NonNull EditText editTextLastName,
      @NonNull EditText editTextPesel, @NonNull EditText editTextPhoneNumber) {
    this.rootView = rootView;
    this.buttonSaveChanges = buttonSaveChanges;
    this.editTextAddress = editTextAddress;
    this.editTextEmail = editTextEmail;
    this.editTextFirstName = editTextFirstName;
    this.editTextIdNumber = editTextIdNumber;
    this.editTextLastName = editTextLastName;
    this.editTextPesel = editTextPesel;
    this.editTextPhoneNumber = editTextPhoneNumber;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonSaveChanges;
      Button buttonSaveChanges = ViewBindings.findChildViewById(rootView, id);
      if (buttonSaveChanges == null) {
        break missingId;
      }

      id = R.id.editTextAddress;
      EditText editTextAddress = ViewBindings.findChildViewById(rootView, id);
      if (editTextAddress == null) {
        break missingId;
      }

      id = R.id.editTextEmail;
      EditText editTextEmail = ViewBindings.findChildViewById(rootView, id);
      if (editTextEmail == null) {
        break missingId;
      }

      id = R.id.editTextFirstName;
      EditText editTextFirstName = ViewBindings.findChildViewById(rootView, id);
      if (editTextFirstName == null) {
        break missingId;
      }

      id = R.id.editTextIdNumber;
      EditText editTextIdNumber = ViewBindings.findChildViewById(rootView, id);
      if (editTextIdNumber == null) {
        break missingId;
      }

      id = R.id.editTextLastName;
      EditText editTextLastName = ViewBindings.findChildViewById(rootView, id);
      if (editTextLastName == null) {
        break missingId;
      }

      id = R.id.editTextPesel;
      EditText editTextPesel = ViewBindings.findChildViewById(rootView, id);
      if (editTextPesel == null) {
        break missingId;
      }

      id = R.id.editTextPhoneNumber;
      EditText editTextPhoneNumber = ViewBindings.findChildViewById(rootView, id);
      if (editTextPhoneNumber == null) {
        break missingId;
      }

      return new ActivityEditProfileBinding((RelativeLayout) rootView, buttonSaveChanges,
          editTextAddress, editTextEmail, editTextFirstName, editTextIdNumber, editTextLastName,
          editTextPesel, editTextPhoneNumber);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
