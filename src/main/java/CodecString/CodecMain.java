package CodecString;

import org.apache.commons.cli.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;

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
    @Autowired
    protected static MyCodec codec;

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
        String str1 = "Marolok";
        Options options = new Options();
        // Тут добавляются новые опции(Options) для парсера командной строки.
        options.addOption( "s", "string", true, "test String ." );
        //-------------
        try
        {
            CommandLine line = getCommandLine(options, args);
            if(line.hasOption("string")){
                str1 = line.getOptionValue("string");
            }
            // Кодируем
            String str2 = codec.getCodingString(str1);
            // Декодируем закодированное
            String str3 = codec.getDecodingString(str2);
            // Выводим результат
            System.out.println(
                    "FROM - "+str1+"\n" +
                    "TO/FROM - "+str2+"\n" +
                    "TO - "+str3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programm end");
        }
    }
}
