package avivn.mmn12.q1;

/**
 * Respresents an employee who gets paid by a manufactured piece number
 * @author Aviv Naaman
 * @version 2022a
 */
public class PieceWorker extends Employee {
    // Payment amount per piece
    private final double earningPerPiece;
    // Number of manufactured pieces
    private final int producedPieces;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
                       BirthDate birthDate, double earningPerPiece, int producedPieces) {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        this.earningPerPiece = earningPerPiece;
        this.producedPieces = producedPieces;
    }

    @Override
    public double earnings() {
        return earningPerPiece * producedPieces;
    }

    @Override
    public String toString() {
        return String.format("%s %s%n%s: %.2f$; %s: %d",
                "piece-worker", super.toString(),
                "earning per piece", earningPerPiece,
                "produced pieces", producedPieces);
    }
}
