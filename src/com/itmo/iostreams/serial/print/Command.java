package com.itmo.iostreams.serial.print;

/**
 * Created by Юлия on 18.04.2017.
 */
public interface Command <T>{
    <T extends Command> CommandCode getCode();
}
