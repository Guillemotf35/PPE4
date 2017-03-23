<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * tarif
 *
 * @ORM\Table(name="tarif")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\tarifRepository")
 */
class tarif
{
    /**
     * @var int
     *
     * @ORM\Column(name="id", type="integer")
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="AUTO")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="prixQuartHeure", type="string", length=255)
     */
    private $prixQuartHeure;


    /**
     * Get id
     *
     * @return int
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set prixQuartHeure
     *
     * @param string $prixQuartHeure
     *
     * @return tarif
     */
    public function setPrixQuartHeure($prixQuartHeure)
    {
        $this->prixQuartHeure = $prixQuartHeure;

        return $this;
    }

    /**
     * Get prixQuartHeure
     *
     * @return string
     */
    public function getPrixQuartHeure()
    {
        return $this->prixQuartHeure;
    }


      public function __toString()
    {
        return $this->prixQuartHeure;     
    }
}
