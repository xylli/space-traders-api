package com.deatr.xylli.speatr.client;

import com.deatr.xylli.speatr.dto.DataListWrapper;
import com.deatr.xylli.speatr.dto.DataWrapper;
import com.deatr.xylli.speatr.dto.data.Cooldown;
import com.deatr.xylli.speatr.dto.data.ship.Ship;
import com.deatr.xylli.speatr.dto.data.ship.ShipCargo;
import com.deatr.xylli.speatr.dto.request.*;
import com.deatr.xylli.speatr.dto.response.ChartResponse;
import com.deatr.xylli.speatr.dto.response.OrbitResponse;
import com.deatr.xylli.speatr.dto.response.PurchaseShipResponse;
import com.deatr.xylli.speatr.dto.response.ShipRefineResponse;
import com.fasterxml.jackson.databind.JsonNode;
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

@Validated
public interface FleetClient {

    @GetExchange("/my/ships")
    DataListWrapper<Ship> listMyShips(
            @RequestParam @Positive @Max(20) int limit,
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
    DataWrapper<JsonNode> dock(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/survey")
    DataWrapper<JsonNode> survey(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/extract")
    DataWrapper<JsonNode> extract(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull JsonNode body
    );


    @PostExchange("/my/ships/{shipSymbol}/jettison")
    DataWrapper<JsonNode> jettison(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotNull JsonNode body
    );

    @PostExchange("/my/ships/{shipSymbol}/jump")
    DataWrapper<JsonNode> jump(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank JumpRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/navigate")
    DataWrapper<JsonNode> navigate(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank NavigateRequest body
    );

    @PatchExchange("/my/ships/{shipSymbol}/nav")
    DataWrapper<JsonNode> updateNav(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank UpdateNavRequest body
    );

    @GetExchange("/my/ships/{shipSymbol}/nav")
    DataWrapper<JsonNode> getNav(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/warp")
    DataWrapper<JsonNode> warp(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank WarpRequest body
    );

    @PostExchange("/my/ships/{shipSymbol}/sell")
    DataWrapper<JsonNode> sell(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank JsonNode body
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/systems")
    DataWrapper<JsonNode> scanSystems(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/waypoints")
    DataWrapper<JsonNode> scanWaypoints(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/ships")
    DataWrapper<JsonNode> scanShips(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/scan/refuel")
    DataWrapper<JsonNode> refuel(
            @PathVariable @NotBlank String shipSymbol
    );

    @PostExchange("/my/ships/{shipSymbol}/purchase")
    DataWrapper<JsonNode> purchaseCargo(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank JsonNode body
    );

    @PostExchange("/my/ships/{shipSymbol}/transfer")
    DataWrapper<JsonNode> transferCargo(
            @PathVariable @NotBlank String shipSymbol,
            @RequestBody @NotBlank JsonNode body
    );


}
