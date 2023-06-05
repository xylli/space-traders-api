package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.ship.Ship;
import com.deatr.xylli.speatr.dto.data.ship.ShipCargo;
import com.deatr.xylli.speatr.dto.data.ship.ShipNav;
import com.deatr.xylli.speatr.dto.request.*;
import com.deatr.xylli.speatr.dto.response.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;

import static com.deatr.xylli.speatr.util.ApiConstants.FIRST_PAGE;
import static com.deatr.xylli.speatr.util.ApiConstants.LIST_REQUEST_LIMIT;

@Validated
public interface FleetClient {

    default DataListWrapper<Ship> getMyFirstShips() {
        return getMyShips(LIST_REQUEST_LIMIT, FIRST_PAGE);
    }

    @GetExchange("/my/ships")
    DataListWrapper<Ship> getMyShips(
            @RequestParam @Positive @Max(LIST_REQUEST_LIMIT) int limit,
            @RequestParam @Positive int page
    );

    @PostExchange("/my/ships")
    DataWrapper<PurchaseShipResponse> purchaseShip(
            @RequestBody PurchaseShipRequest body
    );

    @GetExchange("/my/ships/{shipSymbol}")
    DataWrapper<Ship> getShip(
            @PathVariable @NotBlank String shipSymbol
    );

    @GetExchange("/my/ships/{shipSymbol}")
    DataWrapper<ShipCargo> getShipCargo(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/orbit")
    DataWrapper<OrbitResponse> orbit(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/refine")
    DataWrapper<ShipRefineResponse> refine(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull RefineRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/chart")
    DataWrapper<ChartResponse> chart(
            @PathVariable @NotBlank String shipSymbol
    );

    @GetExchange("/my/ships/{shipSymbol}/cooldown")
    DataWrapper<Cooldown> getCooldown(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/dock")
    DataWrapper<DockShipResponse> dock(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/survey")
    DataWrapper<SurveyResponse> survey(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/extract")
    DataWrapper<ExtractResponse> extract(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull ExtractRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/jettison")
    DataWrapper<JettisonResponse> jettison(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull JettisonRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/jump")
    DataWrapper<JumpResponse> jump(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull JumpRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/navigate")
    DataWrapper<NavigateResponse> navigate(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull NavigateRequest body
    );

    @PatchExchange("/my/ships/{shipSymbol}/nav")
    DataWrapper<ShipNav> updateNav(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull UpdateNavRequest body
    );

    @GetExchange("/my/ships/{shipSymbol}/nav")
    DataWrapper<ShipNav> getNav(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/warp")
    DataWrapper<WarpResponse> warp(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull WarpRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/sell")
    DataWrapper<SellCargoResponse> sell(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull SellCargoRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/systems")
    DataWrapper<ScanSystemsResponse> scanSystems(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/waypoints")
    DataWrapper<ScanWaypointsResponse> scanWaypoints(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/ships")
    DataWrapper<ScanShipsResponse> scanShips(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/refuel")
    DataWrapper<RefuelResponse> refuel(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/purchase")
    DataWrapper<PurchaseCargoResponse> purchaseCargo(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull PurchaseCargoRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/transfer")
    DataWrapper<TransferCargoResponse> transferCargo(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull TransferCargoRequest body
    );


}
