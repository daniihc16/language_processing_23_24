/* alikeTokenManager.java */
/* Generated By:JavaCC: Do not edit this line. alikeTokenManager.java */
package traductor;
import lib.symbolTable.*;
import java.util.*;

/** Token Manager. */
@SuppressWarnings ("unused")
public class alikeTokenManager implements alikeConstants {
        static void CommonTokenAction(Token token) {
                if (token.kind == tRESTO) System.out.println("ERROR LEXICO: (" + token.beginLine + ", " + token.beginColumn + "): simbolo no reconocido: " + token.image);
                System.out.println("(" + token.beginLine + ", " + token.beginColumn + "): " + alikeConstants.tokenImage[token.kind] + " " + token.image);
                System.err.println(st.toString());
        }

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_1(int pos, long active0){
   switch (pos)
   {
      case 0:
         if ((active0 & 0x100000000L) != 0L)
            return 0;
         if ((active0 & 0xfff0200767ff600L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 0;
            return 14;
         }
         return -1;
      case 1:
         if ((active0 & 0x40000020006000L) != 0L)
            return 14;
         if ((active0 & 0xfbf0200567f9600L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 1;
            return 14;
         }
         return -1;
      case 2:
         if ((active0 & 0xe020050001400L) != 0L)
            return 14;
         if ((active0 & 0xfb10000067f8200L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 60;
               jjmatchedPos = 2;
            }
            return 14;
         }
         return -1;
      case 3:
         if ((active0 & 0xa80000002020000L) != 0L)
            return 14;
         if ((active0 & 0x5350000047d8200L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 3;
            return 14;
         }
         return -1;
      case 4:
         if ((active0 & 0x500000004040200L) != 0L)
            return 14;
         if ((active0 & 0x35000000798000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 4;
            return 14;
         }
         return -1;
      case 5:
         if ((active0 & 0x35000000718000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 5;
            return 14;
         }
         if ((active0 & 0x80000L) != 0L)
            return 14;
         return -1;
      case 6:
         if ((active0 & 0x600000L) != 0L)
            return 14;
         if ((active0 & 0x35000000118000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 6;
            return 14;
         }
         return -1;
      case 7:
         if ((active0 & 0x34000000010000L) != 0L)
            return 14;
         if ((active0 & 0x1000000108000L) != 0L)
         {
            jjmatchedKind = 60;
            jjmatchedPos = 7;
            return 14;
         }
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_1(int pos, long active0){
   return jjMoveNfa_1(jjStopStringLiteralDfa_1(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjMoveStringLiteralDfa0_1(){
   switch(curChar)
   {
      case 40:
         return jjStopAtPos(0, 42);
      case 41:
         return jjStopAtPos(0, 43);
      case 42:
         return jjStopAtPos(0, 33);
      case 43:
         return jjStopAtPos(0, 31);
      case 44:
         return jjStopAtPos(0, 46);
      case 45:
         return jjStartNfaWithStates_1(0, 32, 0);
      case 46:
         return jjMoveStringLiteralDfa1_1(0x800000000000L);
      case 47:
         {
         jjmatchedKind = 34;
         jjmatchedPos = 0;
         }
         return jjMoveStringLiteralDfa1_1(0x4000000000L);
      case 58:
         {
         jjmatchedKind = 45;
         jjmatchedPos = 0;
         }
         return jjMoveStringLiteralDfa1_1(0x800L);
      case 59:
         return jjStopAtPos(0, 44);
      case 60:
         {
         jjmatchedKind = 35;
         jjmatchedPos = 0;
         }
         return jjMoveStringLiteralDfa1_1(0x8000000000L);
      case 61:
         return jjStopAtPos(0, 37);
      case 62:
         {
         jjmatchedKind = 36;
         jjmatchedPos = 0;
         }
         return jjMoveStringLiteralDfa1_1(0x10000000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa1_1(0x10040000L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_1(0x200200L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_1(0x20000000100000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_1(0x180000000000400L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_1(0x4010000L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa1_1(0x2000000000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_1(0x50000000402000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa1_1(0x800000000000000L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa1_1(0x20000000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_1(0x40020000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa1_1(0x20004000L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa1_1(0xc000000008000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_1(0x81000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_1(0x1000000000000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_1(0x200000002000000L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_1(0x400000000000000L);
      default :
         return jjMoveNfa_1(3, 0);
   }
}
static private int jjMoveStringLiteralDfa1_1(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 46:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         break;
      case 61:
         if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(1, 11);
         else if ((active0 & 0x4000000000L) != 0L)
            return jjStopAtPos(1, 38);
         else if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(1, 40);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_1(active0, 0x4000000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_1(active0, 0x2000000081200L);
      case 70:
      case 102:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_1(1, 14, 14);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_1(1, 54, 14);
         break;
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_1(active0, 0x620000000100000L);
      case 75:
      case 107:
         return jjMoveStringLiteralDfa2_1(active0, 0x1000000000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_1(active0, 0x180000000000000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa2_1(active0, 0x10000010400400L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa2_1(active0, 0x800020040200000L);
      case 82:
      case 114:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_1(1, 29, 14);
         return jjMoveStringLiteralDfa2_1(active0, 0x2048000L);
      case 83:
      case 115:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_1(1, 13, 14);
         break;
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_1(active0, 0xc000000030000L);
      default :
         break;
   }
   return jjStartNfa_1(0, active0);
}
static private int jjMoveStringLiteralDfa2_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa3_1(active0, 0x20000000100000L);
      case 68:
      case 100:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_1(2, 10, 14);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_1(2, 28, 14);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_1(2, 41, 14);
         break;
      case 69:
      case 101:
         return jjMoveStringLiteralDfa3_1(active0, 0x200000000000000L);
      case 70:
      case 102:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_1(2, 12, 14);
         break;
      case 71:
      case 103:
         return jjMoveStringLiteralDfa3_1(active0, 0x200L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_1(active0, 0x401000000000000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_1(active0, 0x4020000L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa3_1(active0, 0x10000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_1(active0, 0x800000000208000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa3_1(active0, 0x40000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_1(active0, 0x180000000000000L);
      case 84:
      case 116:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_1(2, 30, 14);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_1(2, 49, 14);
         else if ((active0 & 0x8000000000000L) != 0L)
         {
            jjmatchedKind = 51;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_1(active0, 0x14000000480000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_1(active0, 0x2000000L);
      default :
         break;
   }
   return jjStartNfa_1(1, active0);
}
static private int jjMoveStringLiteralDfa3_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa4_1(active0, 0x10000000000000L);
      case 95:
         return jjMoveStringLiteralDfa4_1(active0, 0x4000000000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_1(active0, 0x40000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa4_1(active0, 0x18000L);
      case 69:
      case 101:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_1(3, 25, 14);
         else if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 55, 14);
         return jjMoveStringLiteralDfa4_1(active0, 0x400000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa4_1(active0, 0x100000000000200L);
      case 76:
      case 108:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_1(3, 17, 14);
         return jjMoveStringLiteralDfa4_1(active0, 0x400000000200000L);
      case 78:
      case 110:
         if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 57, 14);
         break;
      case 80:
      case 112:
         if ((active0 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_1(3, 59, 14);
         return jjMoveStringLiteralDfa4_1(active0, 0x1000000000000L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa4_1(active0, 0x20000000100000L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa4_1(active0, 0x4000000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_1(active0, 0x80000L);
      default :
         break;
   }
   return jjStartNfa_1(2, active0);
}
static private int jjMoveStringLiteralDfa4_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 50:
         return jjMoveStringLiteralDfa5_1(active0, 0x20000000000000L);
      case 95:
         return jjMoveStringLiteralDfa5_1(active0, 0x1000000000000L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa5_1(active0, 0x100000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_1(active0, 0x10000000000000L);
      case 69:
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_1(4, 26, 14);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 58, 14);
         return jjMoveStringLiteralDfa5_1(active0, 0x208000L);
      case 70:
      case 102:
         if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_1(4, 56, 14);
         break;
      case 71:
      case 103:
         return jjMoveStringLiteralDfa5_1(active0, 0x400000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa5_1(active0, 0x4000000000000L);
      case 78:
      case 110:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_1(4, 9, 14);
         break;
      case 82:
      case 114:
         return jjMoveStringLiteralDfa5_1(active0, 0x80000L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa5_1(active0, 0x10000L);
      case 89:
      case 121:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_1(4, 18, 14);
         break;
      default :
         break;
   }
   return jjStartNfa_1(3, active0);
}
static private int jjMoveStringLiteralDfa5_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa6_1(active0, 0x200000L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa6_1(active0, 0x100000L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa6_1(active0, 0x8000L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa6_1(active0, 0x400000L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa6_1(active0, 0x10000000000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa6_1(active0, 0x24000000010000L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa6_1(active0, 0x1000000000000L);
      case 78:
      case 110:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_1(5, 19, 14);
         break;
      default :
         break;
   }
   return jjStartNfa_1(4, active0);
}
static private int jjMoveStringLiteralDfa6_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa7_1(active0, 0x10000000000000L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa7_1(active0, 0x1000000000000L);
      case 78:
      case 110:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_1(6, 21, 14);
         return jjMoveStringLiteralDfa7_1(active0, 0x24000000000000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa7_1(active0, 0x10000L);
      case 82:
      case 114:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_1(6, 22, 14);
         break;
      case 84:
      case 116:
         return jjMoveStringLiteralDfa7_1(active0, 0x100000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa7_1(active0, 0x8000L);
      default :
         break;
   }
   return jjStartNfa_1(5, active0);
}
static private int jjMoveStringLiteralDfa7_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_1(7, 50, 14);
         return jjMoveStringLiteralDfa8_1(active0, 0x100000L);
      case 78:
      case 110:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_1(7, 16, 14);
         return jjMoveStringLiteralDfa8_1(active0, 0x1000000000000L);
      case 82:
      case 114:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_1(7, 52, 14);
         return jjMoveStringLiteralDfa8_1(active0, 0x8000L);
      case 84:
      case 116:
         if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_1(7, 53, 14);
         break;
      default :
         break;
   }
   return jjStartNfa_1(6, active0);
}
static private int jjMoveStringLiteralDfa8_1(long old0, long active0){
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_1(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_1(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_1(8, 15, 14);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_1(8, 48, 14);
         break;
      case 82:
      case 114:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_1(8, 20, 14);
         break;
      default :
         break;
   }
   return jjStartNfa_1(7, active0);
}
static private int jjStartNfaWithStates_1(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_1(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static private int jjMoveNfa_1(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 15;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 24)
                        kind = 24;
                     { jjCheckNAdd(7); }
                  }
                  else if (curChar == 34)
                     { jjCheckNAddStates(0, 2); }
                  else if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 5;
                  else if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar == 45)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 1:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     { jjCheckNAddTwoStates(1, 2); }
                  break;
               case 2:
                  if (curChar == 10)
                     kind = 2;
                  break;
               case 4:
                  if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 5:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 6:
                  if (curChar == 39 && kind > 23)
                     kind = 23;
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 24)
                     kind = 24;
                  { jjCheckNAdd(7); }
                  break;
               case 8:
               case 10:
                  if (curChar == 34)
                     { jjCheckNAddStates(0, 2); }
                  break;
               case 9:
                  if ((0xfffffffbfffffbffL & l) != 0L)
                     { jjCheckNAddStates(0, 2); }
                  break;
               case 11:
                  if (curChar == 34)
                     jjstateSet[jjnewStateCnt++] = 10;
                  break;
               case 12:
                  if (curChar == 34 && kind > 27)
                     kind = 27;
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  jjstateSet[jjnewStateCnt++] = 14;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 3:
               case 14:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 60)
                     kind = 60;
                  { jjCheckNAdd(14); }
                  break;
               case 1:
                  { jjAddStates(3, 4); }
                  break;
               case 5:
                  jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 9:
                  { jjAddStates(0, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(3, 4); }
                  break;
               case 5:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 6;
                  break;
               case 9:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     { jjAddStates(0, 2); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 15 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 34:
         return jjStopAtPos(0, 1);
      default :
         return 1;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, "\72\75", null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, "\53", "\55", "\52", "\57", "\74", "\76", "\75", "\57\75", 
"\74\75", "\76\75", null, "\50", "\51", "\73", "\72", "\54", "\56\56", null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, };
static protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   if (jjmatchedPos < 0)
   {
      if (image == null)
         curTokenImage = "";
      else
         curTokenImage = image.toString();
      beginLine = endLine = input_stream.getEndLine();
      beginColumn = endColumn = input_stream.getEndColumn();
   }
   else
   {
      String im = jjstrLiteralImages[jjmatchedKind];
      curTokenImage = (im == null) ? input_stream.GetImage() : im;
      beginLine = input_stream.getBeginLine();
      beginColumn = input_stream.getBeginColumn();
      endLine = input_stream.getEndLine();
      endColumn = input_stream.getEndColumn();
   }
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}
static final int[] jjnextStates = {
   9, 11, 12, 1, 2, 
};

static int curLexState = 1;
static int defaultLexState = 1;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   switch(curLexState)
   {
     case 0:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 62;
       jjmatchedPos = -1;
       curPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos < 0 || (jjmatchedPos == 0 && jjmatchedKind > 61))
       {
          jjmatchedKind = 61;
          jjmatchedPos = 0;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           TokenLexicalActions(matchedToken);
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
static void TokenLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 27 :
        image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
        // quitamos la doble "" por "
        matchedToken.image = image.toString().replaceAll("\"\"", "\"");
         break;
      default :
         break;
   }
}
static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public alikeTokenManager(SimpleCharStream stream){

      if (input_stream != null)
        throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);

    input_stream = stream;
  }

  /** Constructor. */
  public alikeTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  
  static public void ReInit(SimpleCharStream stream)
  {


    jjmatchedPos =
    jjnewStateCnt =
    0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  static private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 15; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  static public void ReInit(SimpleCharStream stream, int lexState)
  
  {
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public static void SwitchTo(int lexState)
  {
    if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }


/** Lexer state names. */
public static final String[] lexStateNames = {
   "COMILLAS",
   "DEFAULT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x7ffffffffffffe01L, 
};
static final long[] jjtoSkip = {
   0x7eL, 
};
static final long[] jjtoSpecial = {
   0x0L, 
};
static final long[] jjtoMore = {
   0x0L, 
};
    static protected SimpleCharStream  input_stream;

    static private final int[] jjrounds = new int[15];
    static private final int[] jjstateSet = new int[2 * 15];
    private static final StringBuilder jjimage = new StringBuilder();
    private static StringBuilder image = jjimage;
    private static int jjimageLen;
    private static int lengthOfMatch;
    static protected int curChar;
}
