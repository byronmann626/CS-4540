package com.example.finalproject.databinding;
import com.example.finalproject.R;
import com.example.finalproject.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSettingsBindingImpl extends FragmentSettingsBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.timePicker1, 1);
        sViewsWithIds.put(R.id.chipGroup, 2);
        sViewsWithIds.put(R.id.monday, 3);
        sViewsWithIds.put(R.id.tuesday, 4);
        sViewsWithIds.put(R.id.wednesday, 5);
        sViewsWithIds.put(R.id.thursday, 6);
        sViewsWithIds.put(R.id.friday, 7);
        sViewsWithIds.put(R.id.saturday, 8);
        sViewsWithIds.put(R.id.sunday, 9);
        sViewsWithIds.put(R.id.okButton, 10);
        sViewsWithIds.put(R.id.cancelButton, 11);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentSettingsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentSettingsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.Button) bindings[11]
            , (com.google.android.material.chip.ChipGroup) bindings[2]
            , (com.google.android.material.chip.Chip) bindings[7]
            , (com.google.android.material.chip.Chip) bindings[3]
            , (android.widget.Button) bindings[10]
            , (com.google.android.material.chip.Chip) bindings[8]
            , (com.google.android.material.chip.Chip) bindings[9]
            , (com.google.android.material.chip.Chip) bindings[6]
            , (android.widget.TimePicker) bindings[1]
            , (com.google.android.material.chip.Chip) bindings[4]
            , (com.google.android.material.chip.Chip) bindings[5]
            );
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.Settings == variableId) {
            setSettings((com.example.finalproject.SettingsFragment) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setSettings(@Nullable com.example.finalproject.SettingsFragment Settings) {
        this.mSettings = Settings;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): Settings
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}