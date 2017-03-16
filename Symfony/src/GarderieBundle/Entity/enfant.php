<?php

namespace GarderieBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * enfant
 *
 * @ORM\Table(name="enfant")
 * @ORM\Entity(repositoryClass="GarderieBundle\Repository\enfantRepository")
 */
class enfant
{
    /**
    * @ORM\ManyToOne(targetEntity="GarderieBundle\Entity\responsableLegal",cascade={"persist"})
    * @ORM\JoinColumn(nullable=false)
    */
    private $responsableLegal;

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
     * @ORM\Column(name="nom", type="string", length=255)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=255)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="dateNaissance", type="string", length=255)
     */
    private $dateNaissance;


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
     * Set nom
     *
     * @param string $nom
     *
     * @return enfant
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set prenom
     *
     * @param string $prenom
     *
     * @return enfant
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;

        return $this;
    }

    /**
     * Get prenom
     *
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * Set dateNaissance
     *
     * @param string $dateNaissance
     *
     * @return enfant
     */
    public function setDateNaissance($dateNaissance)
    {
        $this->dateNaissance = $dateNaissance;

        return $this;
    }

    /**
     * Get dateNaissance
     *
     * @return string
     */
    public function getDateNaissance()
    {
        return $this->dateNaissance;
    }

    /**
     * Set responsableLegal
     *
     * @param \OC\GarderieBundle\Entity\responsableLegal $responsableLegal
     *
     * @return enfant
     */
    public function setResponsableLegal(\OC\GarderieBundle\Entity\responsableLegal $responsableLegal)
    {
        $this->responsableLegal = $responsableLegal;

        return $this;
    }

    /**
     * Get responsableLegal
     *
     * @return \OC\GarderieBundle\Entity\responsableLegal
     */
    public function getResponsableLegal()
    {
        return $this->responsableLegal;
    }
}
