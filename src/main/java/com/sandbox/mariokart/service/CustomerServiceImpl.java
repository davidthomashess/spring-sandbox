package com.sandbox.mariokart.service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private PlayerRepository playerRepository;

    @Override
    public List<Player> getPlayers() {
        return (List<Player>) playerRepository.findAll();
    }

    @Override
    public Set<Track> getTracksByPlayer(Long id) {
        Player player = getPlayer(id);

        return player.getTracks();
    }

    @Override
    public Player getPlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        return unwrapPlayer(player, id);
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void deletePlayer(Long id) {
        Optional<Player> player = playerRepository.findById(id);

        if (player.isPresent())
            playerRepository.deleteById(id);
        else
            throw new DeleteException();
    }

    static Player unwrapPlayer(Optional<Player> entity, Long id) {
        if (entity.isPresent())
            return entity.get();
        else
            throw new PlayerNotFoundException(id);
    }
}