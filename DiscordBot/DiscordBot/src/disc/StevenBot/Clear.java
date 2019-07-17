package disc.StevenBot;

import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event){
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(StevenBot.prefix + "clear")){
			if (args.length < 2){
				//error
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xf54b42);
				usage.setTitle("Specify amount of messages to delete");
				usage.setDescription("Usage: `" + StevenBot.prefix + "clear [# of messages]`");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else{
				try{
				List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
				event.getChannel().deleteMessages(messages).queue();
				
				//success
				EmbedBuilder success = new EmbedBuilder();
				success.setColor(0x42f542);
				success.setTitle("Successfully deleted " + args[1] + " messages.");
				event.getChannel().sendMessage(success.build()).queue();
				
				
				}
				catch(IllegalArgumentException e){
					if (e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval") || Integer.parseInt(args[1]) < 2) {
						//too many msgs, has be between [1-100] 
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xf54b42);
						error.setTitle("Too many messages");
						error.setDescription("Put a number between 1 and 100");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else{
						//msgs too old [2 weeks +]
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xf54b42);
						error.setTitle("Included Messages are older than 2 weeks");
						error.setDescription("Message older than 2 weeks cannot be deleted");
						event.getChannel().sendMessage(error.build()).queue();
					}
				}
			}
		}
	}
}
