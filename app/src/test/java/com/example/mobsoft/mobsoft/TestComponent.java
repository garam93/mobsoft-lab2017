package com.example.mobsoft.mobsoft;

import com.example.mobsoft.mobsoft.interactor.InteractorModule;
import com.example.mobsoft.mobsoft.mock.MockNetworkModule;
import com.example.mobsoft.mobsoft.repository.TestRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Gabtop on 2017.05.05..
 */

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}