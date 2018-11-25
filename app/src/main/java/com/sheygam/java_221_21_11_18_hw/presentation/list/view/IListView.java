package com.sheygam.java_221_21_11_18_hw.presentation.list.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.sheygam.java_221_21_11_18_hw.presentation.models.ContactViewModel;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IListView extends MvpView {
    void showProgress();
    void hideProgress();
    void updateList(List<ContactViewModel> list);
    void removeContact(int position);
    void updateContact(int position, ContactViewModel contact);
    void addContact(int position, ContactViewModel contact);
    void showEmptyList();
    void showInfoView();
    void showEditView();
}
