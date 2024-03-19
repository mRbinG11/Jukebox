package com.example.demo;

import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

public class Configuration {
        // Singleton Pattern
        // create an object of Single Configuration Object
        private static Configuration instance = new Configuration();

        // make the constructor private so that this class cannot be
        // instantiated
        private Configuration() {}

        // Get the only object available
        public static Configuration getInstance() {
                return instance;
        }

        // Initialize repositories
        private final IGreetingRepository greetingRepository = new GreetingRepository();

        private final ISongRepository songRepository = new SongRepository();
        private final IPlaylistRepository playlistRepository = new PlaylistRepository();

        // Initialize services
        private final GreetingService greetingService = new GreetingService(greetingRepository);

        private final SongService songService = new SongService(songRepository);
        private final PlaylistService playlistService =
                        new PlaylistService(playlistRepository, songRepository);
        private final Player player = new Player(playlistService);

        // Initialize commands
        private final CreateGreetingCommand createGreetingCommand =
                        new CreateGreetingCommand(greetingService);
        private final ListGreetingCommand listGreetingCommand =
                        new ListGreetingCommand(greetingService);
        private final GetGreetingCommand getGreetingCommand =
                        new GetGreetingCommand(greetingService);

        private final AddSongCommand addSongCommand = new AddSongCommand(songService);
        private final ListSongCommand listSongCommand = new ListSongCommand(songService);

        private final CreatePlaylistCommand createPlaylistCommand =
                        new CreatePlaylistCommand(playlistService);
        private final AddSongToPlaylistCommand addSongToPlaylistCommand =
                        new AddSongToPlaylistCommand(playlistService);
        private final DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand =
                        new DeleteSongFromPlaylistCommand(playlistService);
        private final DeletePlaylistCommand deletePlaylistCommand =
                        new DeletePlaylistCommand(playlistService);

        private final LoadPlaylistCommand loadPlaylistCommand = new LoadPlaylistCommand(player);
        private final PlaySongCommand playSongCommand = new PlaySongCommand(player);
        private final NextSongCommand nextSongCommand = new NextSongCommand(player);
        private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(player);
        private final StopSongCommand stopSongCommand = new StopSongCommand(player);

        // Initialize commandRegistery
        private final CommandRegistry commandRegistry = new CommandRegistry();

        // Register commands
        private void registerCommands() {
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),
                                createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),
                                listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),
                                getGreetingCommand);

                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(),
                                addSongCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_SONG_COMMAND.getName(),
                                listSongCommand);

                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST.getName(),
                                createPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST.getName(),
                                addSongToPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST.getName(),
                                deleteSongFromPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST.getName(),
                                deletePlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST.getName(),
                                loadPlaylistCommand);
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG.getName(),
                                playSongCommand);
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG.getName(),
                                nextSongCommand);
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG.getName(),
                                previousSongCommand);
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG.getName(),
                                stopSongCommand);
        }

        public CommandRegistry getCommandRegistry() {
                registerCommands();
                return commandRegistry;
        }
}
