package tutorial3;

public class Q2 {

}

interface BidInterface {
    /**
     * Returns the name of the company making this bid.
     * @return the name of the company
     */
    String getCompanyName();

    /**
     * Returns the description of the air conditioner that this bid is for.
     * @return the description of the air conditioner
     */
    String getACDescription();

    /**
     * Returns the capacity of this bid's AC in tons (1 ton = 12,000 BTU).
     * @return the capacity of the AC
     */
    double getACCapacity();

    /**
     * Returns the seasonal efficiency of this bid's AC (SEER).
     * @return the seasonal efficiency of the AC
     */
    double getACSeasonalEfficiency();

    /**
     * Returns the cost of this bid's AC.
     * @return the cost of the AC
     */
    double getACCost();

    /**
     * Returns the cost of installing this bid's AC.
     * @return the cost of installing the AC
     */
    double getACInstallationCost();

    /**
     * Returns the yearly cost of operating this bid's AC.
     * @return the yearly cost of operating the AC
     */
    double getACYearlyOperationCost();
}

interface BidCollectionInterface<E extends BidInterface> {
    /**
     * Adds a bid to this collection.
     * @param bid the bid to be added
     */
    void addBid(E bid);

    /**
     * Returns the bid in this collection with the best yearly cost.
     * @return the bid in this collection with the best yearly cost
     */
    E getBestYearlyCoseBid();

    /**
     * Returns the bid in this collection with the best initial cost.
     * The initial cost will be defined as the unit cost plus the installation cost.
     * @return the bid in this collection with the best initial cost
     */
    E getBestInitialCostBid();

    /**
     * Clears all of the items from this collection.
     */
    void clear();

    /**
     * Gets the number of items in this collection.
     * @return the number of items in this collection
     */
    int getNumberOfItems();

    /**
     * Sees whether this collection is empty.
     * @return true if this collection is empty, false otherwise
     */
    boolean isEmpty();
}
