package com.tecno_comfenalco.pa.application.storeAssignment.usecases;

import com.tecno_comfenalco.pa.application.storeAssignment.command.actions.GetAllAsignmentDistributorsCommand;
import com.tecno_comfenalco.pa.application.storeAssignment.command.response.GetAllAsignmentDistributorsCommandResult;

public interface StoreAssignmentUseCase {
    GetAllAsignmentDistributorsCommandResult getAllDistributorByStore(GetAllAsignmentDistributorsCommand cmd);
}
