package Objects;

import java.sql.*;
/**
 *
 * @author minh
 */
public class PhieuTraSach {
    private int  mAPHIEUMUON;
    private Date nGAYTRA;

    
    public PhieuTraSach() {
    }

    public PhieuTraSach(int mAPHIEUMUON, Date nGAYTRA) {
        this.mAPHIEUMUON=mAPHIEUMUON;
        this.nGAYTRA = nGAYTRA;
    }
    
    public int getmAPHIEUMUON(){
        return mAPHIEUMUON;
    }
    public void setmAPHIEUMUON(int maPHIEUMUON){
        this.mAPHIEUMUON=maPHIEUMUON;
    }

    public Date getnGAYTRA() {
        return nGAYTRA;
    }

    public void setnGAYTRA(Date nGAYTRA) {
        this.nGAYTRA = nGAYTRA;
    }
}
