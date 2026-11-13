package LogisticsAndDeliveryWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParcelTracker {
    private Map<String, Set<String>> scanHistory;

    public ParcelTracker() {
        this.scanHistory = new HashMap<>();
    }

    public void scanParcel(String trackingNumber, String hubId) {
        // If the tracking number is not in the map yet, create a new set for it
        scanHistory.putIfAbsent(trackingNumber, new HashSet<>());

        Set<String> scannedHubs = scanHistory.get(trackingNumber);

        // Check if the hub ID is already present in the set
        if (scannedHubs.contains(hubId)) {
            System.out.println("[ALERT] Duplicate Scan Detected! Parcel '" + trackingNumber + "' scanned twice at Hub '" + hubId + "'.");
        } else {
            scannedHubs.add(hubId);
            System.out.println("[SUCCESS] Parcel '" + trackingNumber + "' scanned at Hub '" + hubId + "'.");
        }
    }
}
