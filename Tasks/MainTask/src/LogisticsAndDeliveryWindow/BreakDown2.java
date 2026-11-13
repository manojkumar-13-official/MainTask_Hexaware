package LogisticsAndDeliveryWindow;

public class BreakDown2 {
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        System.out.println("--- Processing Parcel Scans ---");

        tracker.scanParcel("TRACK1001", "DEL");
        tracker.scanParcel("TRACK1001", "BOM");
        tracker.scanParcel("TRACK1002", "MAA");
        tracker.scanParcel("TRACK1001", "DEL");
        tracker.scanParcel("TRACK1002", "BLR");
        tracker.scanParcel("TRACK1002", "MAA");
    }
}

