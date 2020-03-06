/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.dagger.registration

import com.example.android.dagger.user.UserManager
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RegistrationViewModelTest {

    private lateinit var userManager: UserManager
    private lateinit var viewModel: RegistrationViewModel

    @Before
    fun setup() {
        userManager = mock(UserManager::class.java)
        viewModel = RegistrationViewModel(userManager)
    }

    @Test
    fun test_acceptTCS(){
        viewModel.acceptTCs()
        /// Only works for
        assertEquals(viewModel.acceptedTCs,true)


    }
    @Test
    fun test_registerUser(){
        viewModel.updateUserData("user","password")
        viewModel.acceptedTCs
        viewModel.registerUser()
        ///If the values are private use verify instead of assert
        verify(userManager).registerUser("user","password")
    }

}
