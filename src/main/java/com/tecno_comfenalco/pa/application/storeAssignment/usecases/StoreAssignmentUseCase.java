package com.tecno_comfenalco.pa.application.storeAssignment.usecases;

import com.tecno_comfenalco.pa.application.storeAssignment.command.actions.GetAllAsignmentDistributorsCommand;
import com.tecno_comfenalco.pa.application.storeAssignment.command.actions.GetAllAsignmentStoresCommand;
import com.tecno_comfenalco.pa.application.storeAssignment.command.response.GetAllAsignmentDistributorsCommandResult;
import com.tecno_comfenalco.pa.application.storeAssignment.command.response.GetAllAsignmentStoresCommandResult;

public interface StoreAssignmentUseCase {
    GetAllAsignmentDistributorsCommandResult getAllDistributorByStore(GetAllAsignmentDistributorsCommand cmd);

    GetAllAsignmentStoresCommandResult getAllStoresByDistributor(GetAllAsignmentStoresCommand cmd);
}
