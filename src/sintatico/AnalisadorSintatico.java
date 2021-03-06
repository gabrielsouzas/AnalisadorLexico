
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Nov 15 16:48:53 BRST 2015
//----------------------------------------------------

package sintatico;

import java_cup.runtime.*;
import java.io.*;
import java.util.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sun Nov 15 16:48:53 BRST 2015
  */
public class AnalisadorSintatico extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalisadorSintatico() {super();}

  /** Constructor which sets the default scanner. */
  public AnalisadorSintatico(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalisadorSintatico(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\005\000\002\002\004\000\002\002\005\000\002\004" +
    "\004\000\002\004\003\000\002\003\013" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\004\004\001\002\000\004\006\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\001\001\002" +
    "\000\004\010\014\001\002\000\006\005\012\006\007\001" +
    "\002\000\006\005\ufffe\006\ufffe\001\002\000\004\002\000" +
    "\001\002\000\006\005\uffff\006\uffff\001\002\000\004\007" +
    "\015\001\002\000\004\010\016\001\002\000\004\011\017" +
    "\001\002\000\004\013\020\001\002\000\004\011\021\001" +
    "\002\000\004\012\022\001\002\000\004\010\023\001\002" +
    "\000\006\005\ufffd\006\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\021\000\004\002\004\001\001\000\006\003\010\004" +
    "\007\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\003\012\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalisadorSintatico$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalisadorSintatico$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalisadorSintatico$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalisadorSintatico$actions {
  private final AnalisadorSintatico parser;

  /** Constructor */
  CUP$AnalisadorSintatico$actions(AnalisadorSintatico parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalisadorSintatico$do_action(
    int                        CUP$AnalisadorSintatico$act_num,
    java_cup.runtime.lr_parser CUP$AnalisadorSintatico$parser,
    java.util.Stack            CUP$AnalisadorSintatico$stack,
    int                        CUP$AnalisadorSintatico$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalisadorSintatico$result;

      /* select the action based on the action number */
      switch (CUP$AnalisadorSintatico$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // _SMITH_ ::= SMITH NUMERO SEPARADOR NUMERO VARIAVEL ATRIBUICAO VARIAVEL MULTIPLICACAO NUMERO 
            {
              Object RESULT =null;

              CUP$AnalisadorSintatico$result = parser.getSymbolFactory().newSymbol("_SMITH_",1, ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-8)), ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.peek()), RESULT);
            }
          return CUP$AnalisadorSintatico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // _BLOCO_ ::= _SMITH_ 
            {
              Object RESULT =null;

              CUP$AnalisadorSintatico$result = parser.getSymbolFactory().newSymbol("_BLOCO_",2, ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.peek()), RESULT);
            }
          return CUP$AnalisadorSintatico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // _BLOCO_ ::= _BLOCO_ _SMITH_ 
            {
              Object RESULT =null;

              CUP$AnalisadorSintatico$result = parser.getSymbolFactory().newSymbol("_BLOCO_",2, ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.peek()), RESULT);
            }
          return CUP$AnalisadorSintatico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // _ORACULOINI_ ::= ORACULOINI _BLOCO_ ORACULOFIM 
            {
              Object RESULT =null;

              CUP$AnalisadorSintatico$result = parser.getSymbolFactory().newSymbol("_ORACULOINI_",0, ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-2)), ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.peek()), RESULT);
            }
          return CUP$AnalisadorSintatico$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= _ORACULOINI_ EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-1)).value;
		RESULT = start_val;
              CUP$AnalisadorSintatico$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.elementAt(CUP$AnalisadorSintatico$top-1)), ((java_cup.runtime.Symbol)CUP$AnalisadorSintatico$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalisadorSintatico$parser.done_parsing();
          return CUP$AnalisadorSintatico$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

