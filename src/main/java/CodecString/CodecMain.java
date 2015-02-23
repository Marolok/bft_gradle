package CodecString;

import org.apache.commons.cli.*;


/*
 * gradle_1.CodecString
 *
 * Created by Marolok - Bocharov Pavel
 *
 * Version - v0.9
 *
 * Date - 18.02.2015
 *
 * License from MarCOM
 */

public class CodecMain {


    /**
     * Возвращает отпарсенную командную строку(args) согласно настроенным опциям(options).
     * @param options
     * @param args
     * @return
     * @throws ParseException
     */
    public static CommandLine getCommandLine(Options options, String[] args) throws ParseException
    {
        CommandLineParser parser = new BasicParser();
        CommandLine line = parser.parse( options, args );
        return line;
    }

    /**
     * Main класс.
     * @param args
     */
    public static void main(String[] args) {
        Options options = new Options();
        // Тут добавляются новые опции(Options) для парсера командной строки.
        options.addOption( "s", "string", true, "test String ." );
        //-------------
        try
        {
            String str1 = "NULL";
            CommandLine line = getCommandLine(options, args);
            if(line.hasOption("string")){
                str1 = line.getOptionValue("string");
            }
            Coder coder = new Coder();
            coder.setSecret(str1);
            // Выводим результат
            System.out.println(
                    "FROM - "+coder.getSecret()+"\n" +
                    "TO/FROM - "+coder.getCodingSecret()+"\n" +
                    "TO - "+coder.getDecodingSecret());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programm end");
        }
    }
}
